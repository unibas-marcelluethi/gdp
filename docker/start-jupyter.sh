#!/bin/bash
echo "DIRECOTRY"
echo $PWD
ls -l
cd ./programming-notebooks; 


# Run the command on container startup
sudo cron

jupyter notebook --ip 0.0.0.0 --notebook-dir=$HOME/programming-notebooks
