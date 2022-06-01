#!/usr/bin/perl

use strict;
use warnings;

use Time::Local;

my $timestring = "11/05/2010 16:27:26.003";
my ($mon, $d, $y, $h, $min, $s, $fraction) =
    $timestring =~ m{(..)/(..)/(....) (..):(..):(..)([.]...)};
$y -= 1900;
$mon--;

my $seconds = timelocal($s, $min, $h, $d, $mon, $y) + $fraction;

print "seconds: $seconds\n";
print "milliseconds: ", $seconds * 1_000, "\n";