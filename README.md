# Staffolani-Porfiri-ProgettoOOP

Progetto per l'esame di programmazione ad oggetti, Università Politecnica delle Marche, Anno 2021/2022

# Introduzione

Il seguente progetto è un Web Service che permette ad un client (es. Postman) di interfacciarsi con le API di Dropbox ed eseguire, mediante chiamate di tipo GET, operazioni su uno specifico account di Dropbox come:

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

## Richieste
Tipo | Rotta | Funzione
---- | ---- | ----
`GET` | /data | restituisce tutti i file presenti nell'account Dropbox sotto forma di JSON 
`GET` | /stats/dates/mostrecent/{extension} | restituisce un **DataModel** contenente il file più recente dell'estensione specificata
`GET` | /stats/dates/leastrecent/{extension} | restituisce un **DataModel** contenente il file meno recente dell'estensione specificata
`GET` | /stats/size/biggestfile/{extension} | restituisce una stringa contenente il nome e la dimensione del più grande file dell'estensione specificata
`GET` | /stats/size/smallestfile/{extension} | restituisce una stringa contenente il nome e la dimensione del più piccolo file dell'estensione specificata
`GET` | /stats/size/higherdim/{size} | restituisce una stringa contenente il numero di file più grandi della dimensione specificata divisi per estensione (X)
`GET` | /stats/size/lowerdim/{size} | restituisce una stringa contenente il numero di file più piccoli della dimensione specificata divisi per estensione (X)
`GET` | /stats/shared/extension/{extension} | restituisce una stringa con il numero di file condivisi per estensione
`GET` | /stats/shared/folder | restituisce una stringa con il numero di file condivisi nella cartella specificata divisi per estensione (X)
`GET` | /filter/*type*/*parameter* | restituisce l'intero database di Dropbox filtrato secondo quanto specificato

###### Nota bene: 
per le richieste contrassegnate dal simbolo (X) le estensioni consentite a scopo dimostrativo sono ".pdf", ".xls", ".jpg", ".doc", "pptx".

## Filtri

I vari tipi di filtro sono:

* **Name**: Restituisce tutti i file il cui nome inizia per la lettera considerata
* **Extension**: Restituisce tutti i file con l'estensione cercata
* **Date**: Restituisce tutti i file la cui ultima modifica risale alla data considerata
* **Path**: Restituisce tutti i file che presentano nel path la sezione considerata
* **Size**: diviso in: **Bigger**: Restituisce tutti i file con dimensione maggiore di quella considerata, e **Smaller**: Restituisce tutti i file con dimensione minore di quella considerata

## Diagrammi UML

### Casi d'uso:
![rotte](https://user-images.githubusercontent.com/94174873/148401729-b00089d1-46b9-40dc-b74a-e57846018dee.png)

### Packages:
![packages](https://user-images.githubusercontent.com/94174873/148401536-ae0624a1-2a40-4175-bf23-ba382a3a4996.jpg)

### utility:
![utility](https://user-images.githubusercontent.com/94174873/148401945-909c90e9-3764-4b98-9f52-b9f5d4177a61.png)

### filters:
![filters](https://user-images.githubusercontent.com/94174873/148402087-0d033e18-3e9a-4ac8-8aca-f4fef3bcba2e.png)

### stats:
![stats](https://user-images.githubusercontent.com/94174873/148402023-0e14093d-1d38-4bd1-b710-567e06b77c3c.png)

### exceptions:
![exceptions](https://user-images.githubusercontent.com/94174873/148402114-4ffc7d9c-1508-4c8b-abec-860e82f29d3c.png)



## Get Started

* avviare Eclipse
* lanciare l'applicazione "project" come Spring Apllication
* avviare Postman
* interrogare le API esposte dalla nostra applicazione secondo una delle rotte esposte precedentemente

## Framework & Software

* **jsonsimple**: libreria utilizata per modellare i file json in oggetti java
*  **Eclipse**: l'ambiente di sviluppo integrato utilizzato per la realizzazione del progetto
* **Spring (v2.6.1)**: Spring Boot è un framework per lo sviluppo di applicazioni web basate su codice Java, offre vantaggi riguardo la parziale automazione del setup e configurazione del progetto e di gestione delle dipendenze                
* **Maven**: strumento di build automation utilizzato per la gestione delle dipendenze dell'applicazione
* **JUnit**: Framework utilizzato per fare test unitari sul codice
* **VisualParadigm**: tool per la creazione dei diagrammi UML

# Autori

Porfiri Pierandrea: S1093332@studenti.univpm.it 

Staffolani Federico: S1097620@studenti.univpm.it
