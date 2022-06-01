#!/usr/bin/perl -w
# Filename : client.pl
# Gabriel Chandesris (2022)

use strict;
use Socket;
use IO::Handle; ## For autoflush
use Time::HiRes qw( sleep usleep );
use Time::Format qw/%time/; ## Need install via "cpan install Time::Format"
use Time::HiRes qw/gettimeofday/;

## Old version to get Time (without milliseconds)
sub getLoggingTime {
    my ($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst) = localtime(time);
    my $nice_timestamp = sprintf ( "%04d%02d%02d %02d:%02d:%02d.%03d",
                                   $year+1900,$mon+1,$mday,$hour,$min,$sec);
    return $nice_timestamp;
}

## New version to get Time (with milliseconds)
sub getTimeStamp {
	my $time = gettimeofday; # Returns ssssssssss.uuuuuu in scalar context
	return qq|$time{'yyyymmdd hh:mm:ss.mmm', $time}\n|;
}

my $timestamping = getTimeStamp(); ## getLoggingTime();
print $timestamping."\n";

## Initialize host and port
my $host = shift || 'localhost';
my $port = shift || 7890;
my $server = "127.0.0.1";  # Host IP running the server

## Create the socket, connect to the port
my $socket;
socket( $socket, PF_INET, SOCK_STREAM, (getprotobyname('tcp'))[2] )
   or die "Can't create a socket $!\n";
connect( $socket, pack_sockaddr_in($port, inet_aton($server)) )
   or die "Can't connect to port $port! \n";

$socket->autoflush();
## Flush after every write : $| = 1;

my $recd;

while(1) {
	## print $socket "DATA [".$timestamping."]";
	print $socket getTimeStamp(); ## $timestamping;
	
	chomp ($recd = <$socket>);
	chomp $recd ;
	print "From server : ".$recd."\n";
	
	## $socket->flush();
	usleep( 50 );
}

close $socket or die "close: $!";
