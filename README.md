Voici un exemple de fichier `README.md` dédié à la partie **Application ToDoList** du projet :

---

# Application ToDoList

L'**Application ToDoList** est un projet Android conçu comme fil conducteur durant notre unité de formation. Au fil des sessions, cette application a évolué pour intégrer les notions essentielles du développement Android avec Kotlin. Elle permet à l'utilisateur de gérer une liste de tâches à réaliser, en assignant une priorité à chacune (Haute, Moyenne ou Basse) et en affichant intelligemment ces tâches à l'écran.

---

## Table des matières

- [Présentation](#présentation)
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Organisation du projet](#organisation-du-projet)
- [Démarrage](#démarrage)
- [Contribution](#contribution)
- [Licence](#licence)

---

## Présentation

Ce projet a pour but de familiariser les étudiants avec les concepts et outils indispensables au développement d'applications Android. Dès la première session, l’application est initiée et enrichie progressivement à travers différents TP et exercices qui abordent :

- La prise en main d'Android Studio et la création d'interfaces simples
- L'utilisation de ListView, puis de RecyclerView avec leurs Adapters
- La compréhension et la gestion du cycle de vie des activités
- La sauvegarde et la récupération des données via SQLite
- La mise en place de préférences utilisateur pour personnaliser l'interface

---

## Fonctionnalités

L'application ToDoList permet de :

- **Ajouter des tâches** : Saisir le nom d'une tâche et lui affecter une priorité (Haute, Moyenne ou Basse).
- **Afficher la liste des tâches** : Les tâches sont présentées dans une liste (ListView puis RecyclerView) qui s'actualise automatiquement lors de l'ajout ou de la suppression d'une tâche.
- **Supprimer des tâches** : Grâce à des interactions gestuelles (exemple : swipe sur un élément) pour supprimer une tâche.
- **Sauvegarder les données** : Utilisation d'une base de données SQLite pour conserver la liste des tâches.
- **Gérer les préférences** : Possibilité d'afficher ou de masquer la priorité et de modifier la taille de la police dans la liste via les préférences de l'application.

---

## Technologies utilisées

- **Langage** : Kotlin (langage recommandé par Google pour Android)
- **IDE** : Android Studio (SDK minimal Android 8)
- **Interface Utilisateur** : 
  - Layouts XML (LinearLayout, ConstraintLayout, etc.)
  - Widgets standards (TextView, EditText, RadioButton, Toast, etc.)
- **Liste** : 
  - Initialement ListView avec Adapter personnalisé
  - Transition vers RecyclerView pour une meilleure gestion du recyclage des vues
- **Base de données** : SQLite (via la mise en place d'un contrat et d'une classe d'assistance)
- **Préférences** : SharedPreferences pour la sauvegarde des paramètres utilisateurs

---

## Organisation du projet

Le développement de l'application ToDoList s'est structuré autour de plusieurs sessions et TP :

1. **Session 1 : Prise en main d'Android Studio & Création d'une interface simple**
   - Création du projet et configuration initiale
   - Mise en place de l'interface graphique (fichier `activity_main.xml` et classe `MainActivity.kt`)
   - Utilisation de Toasts et logs pour le débogage
   - Exercices pour intégrer des widgets (EditText, RadioButtons) et déclencher des événements

2. **Session 2 : ListView, RecyclerView et Adapter(s)**
   - Remplacement de la zone de texte par un ListView, puis migration vers un RecyclerView
   - Implémentation d’Adapters pour gérer dynamiquement la liste des tâches
   - Gestion d’actions utilisateur (exemple : swipe pour supprimer une tâche)

3. **Session 3 : Cycle de vie des activités**
   - Observation et journalisation des méthodes du cycle de vie dans `MainActivity`
   - Gestion des sauvegardes lors de la rotation de l'appareil (implémentation de `Parcelable`)

4. **Session 4 : Sauvegarde des données en base**
   - Création d’une base de données SQLite pour stocker les tâches
   - Intégration d’un contrat de base et des méthodes d’insertion/suppression
   - Actualisation de l’interface via RecyclerView en fonction des modifications de la base

5. **Session 5 : Gestion des préférences**
   - Mise en place d’une interface dédiée aux préférences (affichage, taille de police, etc.)
   - Implémentation de préférences utilisateur avec mise à jour dynamique des affichages

---

## Démarrage

Pour tester et contribuer au projet :

1. **Cloner le dépôt** :

   ```bash
   git clone <URL_DU_DEPOT>
   ```

2. **Ouvrir le projet dans Android Studio** :
   - Lancez Android Studio et choisissez **File > Open**, puis sélectionnez le dossier cloné.

3. **Configurer l'émulateur ou connecter un appareil** :
   - Utilisez un appareil virtuel configuré avec le SDK Android 8 (ou supérieur) ou connectez un appareil physique.

4. **Exécuter l'application** :
   - Cliquez sur le bouton **Run** dans Android Studio pour compiler et lancer l’application.

---

## Contribution

Les contributions pour améliorer et enrichir l'application sont les bienvenues. Pour contribuer :

1. **Forkez le dépôt**
2. **Créez une branche** pour votre fonctionnalité ou correction :

   ```bash
   git checkout -b feature/ma_nouvelle_fonctionnalite
   ```

3. **Committez** vos modifications :

   ```bash
   git commit -m "Ajout de [fonctionnalité/correction] : description succincte"
   ```

4. **Poussez** la branche sur votre fork :

   ```bash
   git push origin feature/ma_nouvelle_fonctionnalite
   ```

5. **Ouvrez une Pull Request** sur le dépôt principal.

---

## Licence

Ce projet est sous licence [MIT](LICENSE).

---

*Ce projet a été développé dans le cadre de notre unité de formation Android afin de mettre en pratique les concepts clés du développement mobile.*

---

N'hésitez pas à adapter ce fichier en fonction de l'évolution du projet et des fonctionnalités ajoutées.
