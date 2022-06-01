#!/usr/bin/perl

use strict;
use warnings;

print localtime(time)."\n";

sub getLoggingTime {
    my ($sec,$min,$hour,$mday,$mon,$year,$wday,$yday,$isdst) = localtime(time);
    my $nice_timestamp = sprintf ( "%04d%02d%02d %02d:%02d:%02d.%03d",
                                   $year+1900,$mon+1,$mday,$hour,$min,$sec,$isdst);
    return $nice_timestamp;
}

