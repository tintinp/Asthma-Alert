# Asthma-Alert
Device to detect asthmatic breathing during sleep
At first, I'm aiming to make this project by using Raspberry Pi, however, there are too many difficulties with recording input from circuit microphone. Therefore, I switched gear to develop an android application instead.

First Attemp:
My first plan is to get the application up and running. Firstly, I created an app that just record audio input and play it back. See the code here.

Log
[03/28/17] - I got simple circuit microphone component from RadioShack and I was trying to record something with Raspberry Pi. Unfortunately, many suggestions online said that it is not capable of doing that. So, I am thinking about what I learned from EE233 Circuit Theory class about recording change in voltage over time. Hence the first thing that I will do is the learn how to record change in voltage with the Pi. To do that, I used this website as a guidance.

[4/14/17] - Turned out that recording audio as a file using audiorecorder might not be the best idea to do it. Hence, I'm moving towards using audiorecord class in order to record bytes from the mic.
