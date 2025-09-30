[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)
Example of an MVC design based on Swing. Answer questions 1 & 2 in this README file.

1.
Swing is a GUI toolkit that extends the older AWT (Abstract Window Toolkit) and provides a richer, more flexible variety of UI components for Java applications. Swing follows an MVC (Model-View-Controller) approach, where each UI component (buttons, sliders, etc.) distinctly separates the model, view, and controller. This enables loose coupling between the logic and presentation of components.

Swing’s use of the MVC architecture aligns with solid software engineering principles. Through SRP (Single Responsibility Principle), the model manages state, the view handles rendering, and the controller processes user input—each with its own focused responsibility. It also follows OCP (Open/Closed Principle), as many Swing classes extend from parent classes without modifying the original code. Additionally, Swing demonstrates Dependency Inversion, since components often rely on interfaces rather than concrete implementations, making code more reusable and adaptable.

Overall, Swing’s MVC-based design makes it a powerful framework for building maintainable and extensible desktop GUI applications.

<img width="1018" height="488" alt="image" src="https://github.com/user-attachments/assets/efb4402d-70dc-4804-99a3-e82611dafb07" />
