---

# Application ToDoList

Je présente ici mon projet **Application ToDoList**, développé dans le cadre de mon unité de formation Android. Ce projet a été conçu comme fil conducteur et a évolué au fil des sessions pour intégrer les principaux concepts du développement Android avec Kotlin. L'application permet à l'utilisateur de gérer une liste de tâches à réaliser, en affectant une priorité à chaque tâche et en les affichant de manière dynamique.

---

## Table des matières

- [Présentation du projet](#présentation-du-projet)
- [Fonctionnalités](#fonctionnalités)
- [Technologies et outils](#technologies-et-outils)
- [Développement et organisation](#développement-et-organisation)
- [Installation et exécution](#installation-et-exécution)
- [Contribution](#contribution)
- [Licence](#licence)

---

## Présentation du projet

Dans le cadre de mes études, j'ai créé cette application pour mettre en pratique divers concepts de développement Android. Dès la première session, j'ai débuté avec la création d'une interface simple dans Android Studio, puis j'ai progressivement intégré :

- La gestion d'interfaces graphiques via XML
- L'utilisation de ListView et RecyclerView associées à des Adapters
- La compréhension du cycle de vie des activités Android
- La sauvegarde de données via une base de données SQLite
- La gestion des préférences utilisateur grâce aux SharedPreferences

Chaque étape du développement a permis d'approfondir mes connaissances et d'améliorer l'application.

---

## Fonctionnalités

L'application ToDoList que j'ai développée offre les fonctionnalités suivantes :

- **Ajout de tâches** : L'utilisateur peut saisir le nom d'une tâche et lui attribuer une priorité (Haute, Moyenne ou Basse).
- **Affichage de la liste des tâches** : La liste est présentée dynamiquement dans un widget (d'abord avec ListView, puis avec RecyclerView) qui se met à jour lors des ajouts ou suppressions.
- **Suppression de tâches** : Grâce à un geste de swipe sur un élément de la liste, l'utilisateur peut supprimer une tâche.
- **Sauvegarde en base de données** : Les tâches sont sauvegardées dans une base SQLite pour garantir leur persistance.
- **Personnalisation via les préférences** : L'application offre la possibilité d'afficher/cacher la priorité et de modifier la taille de la police dans la liste des tâches grâce aux préférences.

---

## Technologies et outils

Pour le développement de cette application, j'ai utilisé les technologies et outils suivants :

- **Langage** : Kotlin (le langage recommandé par Google pour Android)
- **IDE** : Android Studio (avec un SDK minimum Android 8)
- **Interface Utilisateur** :
  - Fichiers XML pour la définition des layouts (LinearLayout, ConstraintLayout, etc.)
  - Widgets standards (TextView, EditText, RadioButton, Toast, etc.)
- **Liste** :
  - Initialement avec ListView et un Adapter personnalisé
  - Transition vers RecyclerView pour une gestion optimisée du recyclage des vues
- **Base de données** : SQLite (mise en place d’un contrat et de méthodes d'insertion/suppression)
- **Préférences** : SharedPreferences pour la sauvegarde et la gestion des paramètres utilisateur

---

## Développement et organisation

Le développement de l'application s'est structuré autour de plusieurs sessions et TP, chacun correspondant à un aspect clé de la formation :

1. **Prise en main d'Android Studio et création d'une interface simple**  
   J'ai commencé par créer un projet vide, puis j'ai ajouté une activité et conçu l'interface graphique (`activity_main.xml`) en utilisant des widgets simples. J'ai également intégré des Toasts et des logs pour faciliter le débogage.

2. **Utilisation de ListView, RecyclerView et Adapters**  
   Pour améliorer la gestion de la liste des tâches, j'ai d'abord utilisé un ListView avant de passer à un RecyclerView, ce qui m'a permis d'apprendre à implémenter des Adapters et à gérer des actions utilisateur comme le swipe pour supprimer des tâches.

3. **Gestion du cycle de vie des activités**  
   J'ai redéfini et logué les méthodes du cycle de vie dans `MainActivity` pour observer et comprendre les changements d'état de l'activité (notamment lors d'une rotation d'écran). J'ai également mis en œuvre l'interface `Parcelable` pour gérer la persistance de l'état.

4. **Sauvegarde des données en base**  
   J'ai intégré une base de données SQLite pour stocker les tâches, ce qui m'a permis de travailler sur la création d'un contrat de base, la gestion de l'insertion et la suppression de données, ainsi que leur affichage dans un RecyclerView.

5. **Implémentation des préférences**  
   Enfin, j'ai ajouté une interface de préférences pour permettre à l'utilisateur de personnaliser l'affichage des tâches (affichage de la priorité, taille de la police, etc.) en utilisant SharedPreferences.

---

## Installation et exécution

Pour installer et exécuter cette application sur votre machine, suivez les étapes ci-dessous :

1. **Cloner le dépôt** :

   ```bash
   git clone <URL_DU_DEPOT>
   ```

2. **Ouvrir le projet dans Android Studio** :
   - Lancez Android Studio et sélectionnez **File > Open**, puis choisissez le dossier cloné.

3. **Configurer l'émulateur ou connecter un appareil** :
   - Vous pouvez utiliser un émulateur configuré avec le SDK Android 8 (ou supérieur) ou connecter un appareil physique.

4. **Exécuter l'application** :
   - Cliquez sur le bouton **Run** pour compiler et lancer l’application.

---

## Contribution

Bien que ce projet ait été réalisé dans le cadre de ma formation, toute suggestion d'amélioration ou contribution est la bienvenue. Si vous souhaitez proposer des modifications :

1. **Forkez le dépôt**.
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

5. **Ouvrez une Pull Request**.

---

## Licence

Ce projet est distribué sous licence [MIT](LICENSE).

---

*Ce projet reflète mon apprentissage progressif du développement Android et m'a permis d'explorer de nombreuses facettes de la création d'applications mobiles. N'hésitez pas à me contacter pour toute question ou suggestion.*

---

N'hésitez pas à adapter ce fichier selon l'évolution de votre projet ou en fonction des ajouts futurs.
