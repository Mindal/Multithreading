# Multithreading
## Ping-Pong problem.
## Description
One thread prints Ping, another prints Pong. Problem is how to synchronize them. There are 3 ways, implemented here.
<li> Synchronized methods, i use wait, notifyAll paradigm to implement it.
<li> Volatile implementation, one thread waits in cycle, easy decision, but threads always check condition in cycle, bad perfomance.
<li> Java.util.concurrent decision, uses simple ReentrantLock, is very similar to synchronized decision.
