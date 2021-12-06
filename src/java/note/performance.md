Algorithm focus on performance, but in many scenarios, performance may be far less valuable than other features, such as security, maintainability, and scalability.

But why is performance important? To some extent, it can be understood that it can be used as a measurement tool, similar to currency, such as using C => Java, sacrificing certain performance in exchange for the characteristics of Java.


Performance is concerned with Running Time, and usually upper bounds: upper limit, maximum value, promise that can be made, At most not least.

T(n) = Max time on any input of size n.

Usually the performance of the algorithm shows different performance on different machines, and what we need to pay attention to is the growth of T(n), that is, ignoring the machine-related conditions. For another understanding, we need to pay attention to n tends to infinity.

For example, if the performance of an algorithm on a certain machine is 3n³ + 9n² + 5n, then its performance is Θ(n³), which is the highest order, ignoring other factors, such as constant terms, such as square terms. These represent It may be other factors, such as computer performance,
But as mentioned earlier, we are concerned about the growth of T(n), because when n tends to infinity, the influence of other factors tends to 0. Even if your constant term is very large, Θ(n³) will definitely be far Higher than Θ(n²) (that is, the performance is lower than the latter).