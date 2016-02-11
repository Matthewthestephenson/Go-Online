# This is a script for copying files from the git folder
# to /var/www/html, where they need to be in order to be 
# seen with a web browser. This script copies every file
# listed in fileList.txt to /var/www/html with the linux
# "cp" command.

from subprocess import call

file = open("fileList.txt")
lines = file.readlines()
for line in lines:
   line = line.strip()
   call(["cp", "G24_MAPP/" + line, "/var/www/html/"]) 
file.close()
