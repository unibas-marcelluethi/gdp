#!/bin/bash
echo "DIRECOTRY"
echo $PWD
ls -l
cd ./programmieren; 
git pull origin master

jupyter notebook --ip 0.0.0.0 --notebook-dir=$HOME/programmieren
