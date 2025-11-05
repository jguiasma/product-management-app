# 🛒 Application Web de Gestion de Produits et Catégories

## 📋 Description
Ce projet est une **application web full-stack** permettant de gérer un **catalogue de produits** organisé par **catégories**.  
Elle offre des fonctionnalités CRUD complètes  et repose sur une architecture **Spring Boot (Back-end)**, **Angular (Front-end)** et **MySQL (Base de données)**.

## ⚙️ Technologies utilisées

### 🌐 Front-end
- **Angular** – Framework front-end
- **TypeScript**, **HTML**, **CSS**
- **Bootstrap** – Interface réactive et ergonomique
- **HttpClient** – Communication avec l’API Spring Boot

### 🖥️ Back-end
- **Spring Boot** – Développement de l’API REST
- **Java (Maven Project)**
- **Spring Data JPA**
- **Lombok**
- **Spring Web**
- **MySQL Driver**

### 🗄️ Base de données
- **MySQL** (via **XAMPP**)
- Relation **One-to-Many** (une catégorie peut avoir plusieurs produits)

## 🚀 Installation et exécution du projet

### 1️⃣ Pré-requis
Avant de commencer, installez :
- [Node.js](https://nodejs.org/)
- [Angular CLI](https://angular.io/cli)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [XAMPP](https://www.apachefriends.org/)
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)

---

### 2️⃣ Base de données (MySQL via XAMPP)
1. Démarrez **XAMPP** puis lancez **Apache** et **MySQL**.  

Configurez les informations de connexion dans le fichier :

backend/gestioncatalogue/src/main/resources/application.properties

3️⃣ Back-end (Spring Boot)
Ouvrez le projet backend dans IntelliJ IDEA.

Attendez le téléchargement automatique des dépendances Maven.

Exécutez le projet :

Run → Run 'GestionCatalogueApplication'
Le serveur démarre par défaut 

4️⃣ Front-end (Angular)
Ouvrez un terminal dans le dossier du projet :

cd frontend/catalogue-frontend
ng serve
Ouvrez votre navigateur sur :
👉 http://localhost:4200

💡 Fonctionnalités principales
Gestion des catégories et des produits

Opérations CRUD complètes

Interface intuitive et responsive

Interaction fluide entre Angular et Spring Boot

Stockage persistant avec MySQL

🧠 Génération du projet Back-end (Spring Initializr)
Le projet a été créé via Spring Initializr avec les métadonnées suivantes :

Project : Maven

Language : Java

Group : com.poly

Artifact : gestioncatalogue

📦 Dépendances :
Lombok

Spring Web

Spring Data JPA
