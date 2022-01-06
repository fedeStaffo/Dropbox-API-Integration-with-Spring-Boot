# Staffolani-Porfiri-ProgettoOOP

Progetto per l'esame di programmazione ad oggetti, Università Politecnica delle Marche, Anno 2021/2022

# Introduzione

Il seguente progetto è un Web Service che permette ad un client (es. Postman) di interfacciarsi con le API di Dropbox ed eseguire, mediante chiamate di tipo GET e POST, operazioni su uno specifico account di Dropbox come:

* Visualizzare tutti i file in formato JSON
* Ottenere statistiche su tali dati
* Ottenere dati filtrati attraverso vari parametri
* Ottenere statistiche sui dati filtrati

Avendo utilizzato il framework SpringBoot, è possibile avviare il programma da Eclipse, utilizzando l'opzione "Run as: SpringBoot App" per far partire in automatico un server Tomcat sulla porta 8080.

## Struttura dei dati

I dati sono strutturati mediante una serie di campi:

1. Nome del file/cartella
2. Percorso del file/cartella
3. Estensione del file
4. Data di ultima modifica del file
5. Dimensione del file
6. Un attributo che indica se i file sono condivisi o meno

# Filtri

I vari tipi di filtro sono:

* **Name**: Restituisce tutti i file il cui nome inizia per la lettera considerata
* **Extension**: Restituisce tutti i file con l'estensione cercata
* **Date**: Restituisce tutti i file la cui ultima modifica risale alla data considerata
* **Path**: Restituisce tutti i file che presentano nel path la sezione considerata
* **Size**: diviso in: **Bigger**: Restituisce tutti i file con dimensione maggiore di quella considerata, e **Smaller**: Restituisce tutti i file con dimensione minore di quella considerata

# Get Started

* avviare Eclipse
* lanciare l'applicazione "project" come Spring Apllication
* avviare Postman
* interrogare le API esposte dalla nostra applicazione secondo una delle rotte esposte precedentemente

# Framework & Software

* **jsonsimple**: libreria utilizata per modellare i file json in oggetti java
* **Spring (v2.6.1)**: Spring Boot è un framework per lo sviluppo di applicazioni web basate su codice Java, offre vantaggi riguardo la parziale automazione del setup e configurazione del progetto e di gestione delle dipendenze                
* **Maven**: strumento di build automation utilizzato per la gestione delle dipendenze dell'applicazione
* **JUnit**: Framework utilizzato per fare test unitari sul codice

# Autori

Porfiri Pierandrea: S1093332@studenti.univpm.it 

Staffolani Federico: S1097620@studenti.univpm.it
