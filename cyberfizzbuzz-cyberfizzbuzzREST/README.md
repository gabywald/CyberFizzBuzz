# Kata "Make Fizz Buzz REST"

## Content of exercice

### Exercise: Write a simple fizz-buzz REST server. 

The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing all multiples of 3 by "fizz", all multiples of 5 by "buzz", and all multiples of 15 by "fizzbuzz". The output would look like this: "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,...".

Your goal is to implement a web server that will expose a REST API endpoint that: 
  * Accepts five parameters : three integers int1, int2 and limit, and two strings str1 and str2.
  * Returns a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all multiples of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.

### The server needs to be:

Ready for production

Easy to maintain by other developers
  * Add a statistics endpoint allowing users to know what the most frequent request has been. 

This endpoint should:
  * Accept no parameter
  * Return the parameters corresponding to the most used request, as well as the number of hits for this request

## Notes for this implementation example

### System and libraries

  * Ubuntu 20.04 LTS
  * Java 1.8 ; JDK is 8.0.252-open
  * Eclipse ; Version: 2020-06 (4.16) ; Build id: I20200604-0540
  * Maven 3.6.3
  * JUnit 5 (not a lot of Unit Tests here ! To be completed !)
  * ... (anything I forgot to mention here, in case anyone wants me to add it here : send message !)

### What is made and some notes

At this time (20220523 : May 23th, 2022) : 
  * Could be run with JerseyLauncher Class
  * Some more precisions to come ?!
  * ... 

