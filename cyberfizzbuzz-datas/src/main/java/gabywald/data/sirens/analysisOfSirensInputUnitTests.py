#!/usr/bin/python3
# -*- coding: utf-8 -*-

import unittest

import analysisOfSirensInput

class TestMethods(unittest.TestCase):

  def sampleReadAndAnalysisFile(self, file: str, attOne : int, attMore : int, attTotal : int):
    dictSIRENcounter = analysisOfSirensInput.AnalysisOfSirensInput.readAndAnalyseFile( file )
    ## Counters
    singleSIREN = 0;
    moreThanOneSIRENS = 0;
    for siren in dictSIRENcounter : 
      if (dictSIRENcounter[siren] == 1):
        singleSIREN += 1
      else:
        moreThanOneSIRENS += 1
    ## Testing results
    self.assertEqual(attOne, singleSIREN)
    self.assertEqual(attMore, moreThanOneSIRENS)
    self.assertEqual(attTotal, len(dictSIRENcounter))

  def test_littletest01(self):
    self.sampleReadAndAnalysisFile( "sirens_littleTest01.txt", 2, 1, 3 )
  
  def test_littletest02(self):
    self.sampleReadAndAnalysisFile( "sirens_littleTest02.txt", 2, 5, 7 )
  
  def test_littletest_fileattempted(self):
    self.sampleReadAndAnalysisFile( "sirens_fxt.txt", 77442, 2256, 77442 + 2256 )


if __name__ == '__main__':
  unittest.main()





