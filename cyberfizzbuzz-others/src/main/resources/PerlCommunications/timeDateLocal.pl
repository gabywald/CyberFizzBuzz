#!/usr/bin/perl

use strict;
use warnings;

use DateTime::Format::Strptime;

my $Strp = new DateTime::Format::Strptime(
    pattern => '%m/%d/%Y %H:%M:%S.%3N',
    time_zone   => '-0800',
);

my $now = DateTime->now;
my $dt  = $Strp->parse_datetime('11/05/2010 23:16:42.003');
my $delta = $now - $dt;

print DateTime->compare( $now, $dt );
print $delta->millisecond;