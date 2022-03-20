#!/bin/bash

mkdir ~/JavaTools
cd ~/JavaTools && { curl -O https://github.com/saturn279/OOP-Java17/blob/main/S1/ArithmeticsTool.jar ; cd -; }
echo "alias armtl='java -jar JavaTools/ArithmeticsTool.jar'" >> ~/.bashrc
echo "alias armtl='java -jar JavaTools/ArithmeticsTool.jar'" >> ~/.zshrc  
echo "Restart your terminal to finish installation"
