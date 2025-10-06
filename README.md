[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)
Example of an MVC design based on Swing. Answer questions 1 & 2 in this README file.

1. Swing is a GUI toolkit that extends the older AWT (Abstract Window Toolkit) and provides a richer, more flexible variety of UI components for Java applications. Swing follows an MVC (Model-View-Controller) approach, where each UI component (buttons, sliders, etc.) distinctly separates the model, view, and controller. This enables loose coupling between the logic and presentation of components.

Swing’s use of the MVC architecture aligns with solid software engineering principles. Through SRP (Single Responsibility Principle), the model manages state, the view handles rendering, and the controller processes user input—each with its own focused responsibility. It also follows OCP (Open/Closed Principle), as many Swing classes extend from parent classes without modifying the original code. Additionally, Swing demonstrates Dependency Inversion, since components often rely on interfaces rather than concrete implementations, making code more reusable and adaptable.

Overall, Swing’s MVC-based design makes it a powerful framework for building maintainable and extensible desktop GUI applications.

<img width="1018" height="488" alt="image" src="https://github.com/user-attachments/assets/efb4402d-70dc-4804-99a3-e82611dafb07" />

2. This example follows the MVC pattern by separating the model (customer name data), the view (Swing interface with text fields, labels, and buttons), and the controller (logic that connects the two). The controller receives user actions through listeners, updates the model when changes are required, and then refreshes the view. The view itself is limited to presentation and exposing components, while the model only stores and provides data, making their responsibilities clearly separated.

However, unlike the conventional MVC pattern described in lectures, the model here does not notify the view or controller when its state changes. You can see in Model.java there is no notifying method to update the view or controllers when the value is changed. Instead the Controller.java class holds the logic to updates the views with the JOptionPane swing toolkit function. In a textbook MVC, the model acts as a publisher and both the controller and view subscribe to updates (Observer pattern), allowing the view to automatically refresh when the model changes. In this Swing implementation, the controller must manually push updates to the view, which makes the controller more central and reduces the dynamic “publish-subscribe” behavior. In addition, the Scanner class is implemented as a standalone Swing component rather than being integrated into the MVC notification loop. This reflects a more pragmatic Swing-oriented variation of MVC compared to the fully decoupled version taught in theory.

4.
![sequence diagram](https://github.com/OTUSOFE365025/assignment2-swing-mvc-group-11-tut-crn-43510/blob/572a22d96f5203bf762cdee8a4559dc22b50f56f/Screenshot%202025-10-06%20151257.png)
