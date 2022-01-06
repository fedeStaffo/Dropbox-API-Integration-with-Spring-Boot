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
###### per le richieste contrassegnate dal simbolo (X) le estensioni consentite a scopo dimostrativo sono ".pdf", ".xls", ".jpg", ".doc", "pptx".

### Esempi di risposta alle rotte:
#### get /data
viene restituita una lista di file e cartelle con i seguenti attributi, la medesima cosa avviene con i filtri che restituiscono la stessa tipologia di lista
```json
   {
        "tag": "folder",
        "name": "sottocartella",
        "extension": "null",
        "id": "id:bzscu_Fx4CUAAAAAAAAAMw",
        "server_modified": "null",
        "size": 0,
        "path": "/Solo mia/sottocartella",
        "shared": false
    },
    {
        "tag": "file",
        "name": "referto copia.doc",
        "extension": ".doc",
        "id": "id:bzscu_Fx4CUAAAAAAAAAOQ",
        "server_modified": "2021-12-27T18:21:59Z",
        "size": 102912,
        "path": "/Solo mia/sottocartella/referto copia.doc",
        "shared": true
    },
```
#### get /stats/dates/mostrecent/.pdf (idem per lastrecent)
restituisce un **DataModel** ossia un file contente come attributi anno, mese, giorno e nome del file che soddisfa i requisiti della richiesta
```json
{
    "year": 2022,
    "month": 1,
    "day": 4,
    "name": "Esecitazione23.11.pdf"
}
```
#### get /stats/size/biggestfile/.doc (idem per smallest)
```txt
The biggest .doc file is referto copia.doc which weight is 12.864 kilobyte
```
#### get /stats/size/higherdim/10000 (idem per lowerdim)
```txt
I file con dimensione maggiore di 10000 sono:
7 pdf
1 documenti excel
5 immagini jpg
1 power point
3 documenti word
```
#### get /stats/shared/extension/.jpg
```txt
The number of .jpg files shared is: 2
```
#### get /stats/shared/folder?path=/Solo mia
restituisce in formato JSON uno **SharedModel** che mostra quanti file per estensione sono stati condivisi in quel percorso e il totale della loro somma
```json
{
    "tot": "Condivisi per cartella: 1",
    "extension1": ".pdf: 1",
    "extension2": ".xls: 0",
    "extension3": ".jpg: 0",
    "extension4": ".pptx: 0",
    "extension5": ".doc: 0"
}
```

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

### com.progettoOOP.project
![controller](https://user-images.githubusercontent.com/94174873/148406449-b130c00b-d6a8-4a06-ae19-6afcd26066e5.png)

### Sequenze:
#### get data
![get data](https://user-images.githubusercontent.com/94174873/148406587-5eb0c841-c898-4076-bb0f-30adb4ebb246.png)
#### get stats on dates
![dates1](https://user-images.githubusercontent.com/94174873/148406599-c3b6388a-44b0-478a-a946-3bf63ec0afdf.png)
![dates2](https://user-images.githubusercontent.com/94174873/148406617-2b281baa-37cd-46ad-8d0f-4b1e292a3e60.png)
#### get stats on size
![size1](https://user-images.githubusercontent.com/94174873/148406642-205640cf-a755-460a-9f6b-acb9cc1bd65f.png)
![size2](https://user-images.githubusercontent.com/94174873/148406662-0c703d45-9176-4229-a6a1-fa084bf6bf7c.png)
![size3](https://user-images.githubusercontent.com/94174873/148406680-23b222fd-e980-49f5-b36c-74039cc7dc9d.png)
![size4](https://user-images.githubusercontent.com/94174873/148406705-d9f7717d-8195-4b93-8de3-3fcac9af4935.png)
#### get stats on shared files
![shared1](https://user-images.githubusercontent.com/94174873/148406765-e2354979-8c05-46c2-80d4-9e2bd18e7590.png)
![shared2](https://user-images.githubusercontent.com/94174873/148406772-33e8edc0-b315-4d5e-b6a9-cdfce1715aaa.png)
#### get filters
![generic filter](https://user-images.githubusercontent.com/94174873/148406791-327c75eb-37d3-4e52-9f0d-7d1b2d1bcde4.png)


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
* **JUnit**: framework utilizzato per fare test unitari sul codice
* **Postman**: tool utilizzato per fare chiamate a http://localhost:8080
* **VisualParadigm**: tool per la creazione dei diagrammi UML

# Autori

Nome | Mail | Contributo
---- | ---- | ----
Porfiri Pierandrea | S1093332@studenti.univpm.it | 50%
Staffolani Federico | S1097620@studenti.univpm.it | 50%
