#!/usr/bin/perl

use 5.30.0;
use warnings;
use IO::Socket::INET;

my $sock = IO::Socket::INET->new("djxmmx.net:17")
    or die "failed to create socket: $!\n";

$sock->send('', 0);

while (<$sock>) {
    print $_;
}

print "\n";

$sock->close();