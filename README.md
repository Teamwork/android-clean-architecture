# Clean Architecture on Android: the Teamwork way!
The purpose of this repository is to showcase, with a very simple but (hopefully) clear test *Android* project, how we have implemented **Clean Architecture** in our applications.
We have put our focus solely into the following areas:
- **Module structure:** each architecture layer has its own module, following closely the Clean principles and naming.
- **Separation of layers**: how to configure Gradle making use of `api`/`implementation` to hide dependencies
- **Dependency Injection:** how to set up Dagger for a multi-module environment, but still ensuring the above point
