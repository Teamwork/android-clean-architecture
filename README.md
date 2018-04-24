# Clean Architecture on Android: the Teamwork.com way!
The purpose of this repository is to showcase, with a very simple but (hopefully) clear test *Android* project, how we have implemented [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html) in our applications.
We have put our focus solely into the following areas:
- **Module structure:** each architecture layer has its own module, following closely the Clean principles and naming.
- **Separation of layers**: how to configure Gradle making use of `api`/`implementation` to hide dependencies
- **Dependency Injection:** how to set up Dagger for a multi-module environment, but still ensuring the above point

## Our requirements
There is no such thing as *"the best architecture"* when it comes to mobile applications: the best architecture approach for a project (or team) always depends on a series of factors and assumptions.

Our solution is based on specific requirements, and, although it might not be the **silver bullet** for every project, it works well and could help you define your own architecture or, at least, inspire you to think about your architecture a little bit more.

We came up with our solution (and we iteratively try to improve it) based on the following items:
- **Software is our craft.** Our applications must be fast, as bug-free as possible and always suiting our customers' needs: the only way to ensure this is to **ensure the quality and maintainability of our code through the use of best practices**.
- **We believe in code reusability.** Modularising our software is the only way to ensure that our code is reusable across products, maximise our bandwidth as a team and ensure that bug fixes are promptly delievered to all of our clients.
- **Our applications are big.** Most of our applications are complex, with non-trivial logic and a significant amount of screens and use cases: **structuring our code in a formal and clear way is essential**.
- **Our applications should endure time.** We don't like technical debt, and we don't like rewriting the same software, using the same technologies, only because that code is broken.
- **We need to scale fast and help new developers.** Using a shared, well-defined architecture helps new developers in the team, who should then be able to contribute faster.