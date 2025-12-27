# 📱 Social Media Application – Spring Core (IoC, DI, Bean Scope)

## 📌 Project Overview

This project is a **console-based Social Media application** built using **Spring Core (XML configuration)** to understand:

* Inversion of Control (IoC)
* Dependency Injection (DI)
* Bean Scope (Singleton & Prototype)
* Real-world use case mapping (Instagram example)

The project demonstrates **why bean scope is important** using a social media posting scenario.

---

## 🧠 Core Concepts Used

### 1️⃣ Inversion of Control (IoC)

Normally in Java, we create objects using the `new` keyword.

```java
Post post = new Post();
```

But in Spring:

* **Spring creates objects**
* **Spring manages object lifecycle**
* We just ask Spring for the object

```java
Post post = (Post) context.getBean("post");
```

👉 This is called **Inversion of Control** (control is inverted from developer to Spring).

---

### 2️⃣ Dependency Injection (DI)

A **dependency** is something an object needs to work.

Example:

* `User` depends on `PostList`
* `PostList` depends on `Post`

Instead of creating dependencies inside the class, **Spring injects them**.

#### Setter Injection Example (used in this project)

```xml
<bean id="user" class="com.example.SocialMedia.SimpleUser">
    <property name="postList" ref="postList"/>
</bean>
```

Spring injects `postList` into `user`.

---

## 🫘 Bean Scope (MOST IMPORTANT CONCEPT)

### What is Bean Scope?

Bean scope defines:

> **How many objects Spring creates when we call `getBean()`**

---

## 🔹 Types of Bean Scope Used

### 1️⃣ Singleton Scope (Default)

```xml
<bean id="postList" class="com.example.SocialMedia.SimplePostList" scope="singleton"/>
```

* Only **ONE object**
* Same object returned every time
* Default behavior in Spring

✔ Used for:

* `User`
* `PostList`

---

### 2️⃣ Prototype Scope

```xml
<bean id="post" class="com.example.SocialMedia.SimplePost" scope="prototype"/>
```

* **New object every time**
* Different instance on each `getBean()`

✔ Used for:

* `Post`

---

## 📸 Real-World Example (Instagram)

### Scenario:

A user uses Instagram:

* Day 1 → Post caption: **"Visited NYC"**
* Day 2 → Post caption: **"Visited Australia"**
* Day 3 → Post caption: **"Visited New Zealand"**

When the user opens Instagram and views posts:
✔ He sees **3 different posts with 3 different captions**

---

## ❌ Problem Without Bean Scope

If `Post` bean is **singleton** (default):

* Same object reused
* Caption gets overwritten every time

### Result ❌

User sees:

```
Visited New Zealand
Visited New Zealand
Visited New Zealand
```

This **does NOT happen in Instagram**.

---

## ✅ Solution: Prototype Scope

```xml
<bean id="post" class="com.example.SocialMedia.SimplePost" scope="prototype"/>
```

✔ New `Post` object for every post
✔ Each caption stored separately
✔ Real-world behavior achieved

---

## 🔁 Why Scope Is Needed in IoC

### Problem:

* In Spring, we **cannot use `new`**
* All objects come from Spring container

### Question:

👉 How do we get a **new object every time**?

### Answer:

➡ **Bean Scope**

* Singleton → same object
* Prototype → new object

---

## 🧩 Mapping Concepts to This Project

| Concept    | Used Where                 |
| ---------- | -------------------------- |
| IoC        | Spring creates all objects |
| DI         | `User` → `PostList`        |
| Singleton  | User, PostList             |
| Prototype  | Post                       |
| XML Config | `applicationContext.xml`   |

---

## 🧠 Code Explanation (Important Line)

```java
postlist.getAllPost().forEach(item -> System.out.println(item.getMessage()));
```

### Step-by-step explanation:

1. `getAllPost()`
   → Returns `List<Post>`

2. `forEach(...)`
   → Loops through each `Post` in the list

3. `item`
   → One `Post` object at a time

4. `item.getMessage()`
   → Gets the caption of that post

5. `System.out.println(...)`
   → Prints the caption

### Equivalent normal loop:

```java
for (Post item : postlist.getAllPost()) {
    System.out.println(item.getMessage());
}
```

---

## ❗ Important Note

If we remove:

```xml
scope="prototype"
```

Then:

* Same post object reused
* All captions become the same
* Wrong social media behavior

---

## 🏁 Conclusion

* **IoC** removes object creation responsibility
* **DI** makes code loosely coupled
* **Bean Scope** solves real-world problems
* Social media apps **must use different scopes**
* This project clearly demonstrates **why prototype scope is needed**
