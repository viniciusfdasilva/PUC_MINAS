#!/bin/sh
#__BEGIN_MAIN__
#
cd /home/vinicius/PUC_MINAS/Computação/AED_II/TP04/
cp series.zip /tmp
cd /tmp/
unzip series.zip
mv series/*.html /tmp
echo FINISH
#__BEGIN_MAIN__
