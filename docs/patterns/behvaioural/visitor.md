## Definition / use

- It allows the developer to separate the object and the operations to be performed on that object.
- Key Idea: Separate the key element (Element interface and ConcreteElement classes) and operations on it (Visitor interface, with concrete operations as VisitorImpl)


## When to use ?

- When the object involves complex or composite structures.
    - Commonly used in compilers, to handle different node types in an AST, without cluttering the node classes with many un-related operations. These operations include evaluation, optimisation, code generation etc.
- Adding operations to a stable class hierarchy.
    - If a class hierarchy is in place. Example: Language -> CobolLanguage, JavaLanguage
    - And there are new operations to be added.
        - I need to actually apply and compare the two codes (with and without the visitor pattern, solving the same problem)
        - Then, it will be clear what are the problems in the pre-visitor case, and how is it solved gracefully.
        - At which point one should think for visitor and not just basic class and attributes.

## A generic class diagram of this situation

- ![Visitor Pattern](./../../diagrams/visitor-class-diagram.png)