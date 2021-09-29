#!/usr/bin/python3
# -*- coding: utf-8 -*-

import sys, getopt
import re

class AnalysisOfSirensInput():
  #Parsing arguments
  def main(argv):
    try:
      opts, args = getopt.getopt(argv,"hi:",["ifile="])
    except getopt.GetoptError:
      print('analysisOfSirensInput.py -i <inputfile>')
      sys.exit(2)
    for opt, arg in opts:
      if opt == '-h':
        print('analysisOfSirensInput.py -i <inputfile>')
        sys.exit()
      elif opt in ("-i", "--ifile"):
        inputfile = arg
    print('Input file is "%s"' %(inputfile) )
    return inputfile
    
  def readAndAnalyseFile(inputfile: str):
    dictSIRENcounter = {}
    ## open file
    with open(inputfile, 'r') as fileCoursesData :
      for line in fileCoursesData.readlines() :
        lineAnalysis = re.match( "^([0-9]{9})$", line)
        if (lineAnalysis != None) :
          siren = lineAnalysis.groups()[0] 
          if (siren in dictSIRENcounter):
            dictSIRENcounter[siren] = dictSIRENcounter[siren]+1
          else:
            dictSIRENcounter[siren] = 1 
        else :
          pass
          ## nothing to do
    ## Counters
    singleSIREN = 0;
    moreThanOneSIRENS = 0;
    for siren in dictSIRENcounter : 
      if (dictSIRENcounter[siren] == 1):
        singleSIREN += 1
      else:
        moreThanOneSIRENS += 1
    ## Printing results
    print("SIREN present once: [%s]" %(singleSIREN) )
    print("SIREN present more: [%s]" %(moreThanOneSIRENS) )
    print("SIREN present total: [%s]" %(len(dictSIRENcounter)) )
    return dictSIRENcounter


inputfile = ''

if __name__ == "__main__":
  inputfile = AnalysisOfSirensInput.main(sys.argv[1:])
  AnalysisOfSirensInput.readAndAnalyseFile(inputfile)





