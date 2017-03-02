# Multithreading
# HomeWork
## Ping-Pong problem.
## Description
One thread prints Ping, another prints Pong. Problem is how to synchronize them. There are 3 ways, implemented here.
1. Synchronized methods, i use wait, notifyAll paradigm to implement it.
2. Volatile implementation, one thread waits in cycle, easy decision, but threads always check condition in cycle, bad perfomance.
3. Java.util.concurrent decision, uses simple ReentrantLock, is very similar to synchronized decision.
