#!/usr/bin/perl -w
# Filename : server.pl

use strict;
use Socket;
use IO::Handle; # for autoflush
use IO::Select; # Select & can_read(0)

# use port 7890 as default
my $port = shift || 7890;
my $proto = getprotobyname('tcp');
my $server = "localhost";  # Host IP running the server

# create a socket, make it reusable
my $socket;
socket($socket, PF_INET, SOCK_STREAM, $proto)
	or die "Can't open socket $!\n";
setsockopt($socket, SOL_SOCKET, SO_REUSEADDR, 1)
	or die "Can't set socket option to SO_REUSEADDR $!\n";

# bind to a port, then listen
bind( $socket, pack_sockaddr_in($port, inet_aton($server)) )
	or die "Can't bind to port $port! \n";

listen($socket, 5) or die "listen: $!";
print "SERVER started on port $port\n";

## # accepting a connection
## my $new_socket;
## while (my $client_addr = accept($new_socket, SOCKET)) {
## 	$new_socket->autoflush();
## 	# flush after every write : $| = 1;
## 	# send them a message, close connection
## 	my ($port, $iaddr) = sockaddr_in($client_addr);
## 	my $name = "client[".$iaddr.":".$port."]"; ## gethostbyaddr( $client_addr, AF_INET );
## 	
## 	print "Connection received from $name"."\n";
## 	
## 	print $new_socket "Smile from the server";
## 	$new_socket->flush();
## 	
## 	while (my $recd = <$new_socket>) {
## 		print "WHILE LOOP\n";
## 		chomp $recd;
## 		print "Got from client: '$recd' "."\n";
## 		print $new_socket "Response from server to |$recd|"."\n";
## 	}
## 	print "EXITING WHILE\n";
## 	close $new_socket;
## }

my %torecord;

my @ready;
my $inp;

my $s = IO::Select->new();
$s->add($socket);

while(1) {
	@ready = $s->can_read(0);
	
	foreach my $so (@ready) {
		# new connection read
		if ($so == $socket) {
			my ($client);
			my $addrinfo = accept($client , $socket);
			
			my ($port, $iaddr) = sockaddr_in($addrinfo);
			my $name = gethostbyaddr($iaddr, AF_INET);
			
			print "Connection accepted from $name : $port \n";
			
			# send some message to the client
			send($client , "Hello client how are you\n" , 0);
			
			$s->add($client);
		}
		
		# existing client read
		else {
			chomp($inp = <$so>);
			if ($inp) {
				chomp($inp);
				print "Received -- $inp \n";
				
				if (! defined( $torecord{$inp} )) 
					{ $torecord{$inp} = 1; }
				
				# send reply back to client
				send($so , "OK : $inp\n" , 0);
			} else {
				$so->close();
			}
		}
	}
	
	if (keys(%torecord) > 1000) {
		open (FILE,">>"."serverrecords.txt");
		foreach my $key (sort(keys(%torecord)) ) {
			print FILE $key."\n";
		}
		close(FILE);
		%torecord = {};
	}
}

# close the socket
close($socket);
exit(0);
