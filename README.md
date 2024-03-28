# ppf-microservices  

**Write data služba:**  
POST 134.209.236.1:8099/createTransactions  
Ukázkový request:  

_curl --location --request POST '134.209.236.1:8099/createTransactions' \
--header 'Content-Type: application/json;charset=UTF-8' \
--data-raw '[ 
{
    "amount": {
        "currency": "CZK",
        "value": 1500
    },
    "bankref": "PS221019SO314822",
    "bookingDate": "2022-10-19",
    "counterPartyAccount": {
        "accountName": "PPF BANKA A.S.",
        "accountNumber": "0000009504010019",
        "bankCode": "6000"
    },
    "creditDebitIndicator": "CRDT",
    "details": {
        "detail1": "Posílám peníze 1"
    },
    "id": "20221019:0000000219",
    "ownAccountNumber": "2002222222",
    "postingDate": "2022-10-19",
    "productBankRef": "PS221019SO314822",
    "specificSymbol": "12",
    "statementNumber": "196",
    "statementPeriod": "2022",
    "transactionId": "4831716",
    "transactionType": "DPO",
    "transactionTypeCode": 1012209,
    "variableSymbol": "12"
},
{
    "amount": {
        "currency": "CZK",
        "value": 1999
    },
    "bankref": "PS221019SO314822",
    "bookingDate": "2022-10-19",
    "counterPartyAccount": {
        "accountName": "PPF BANKA A.S.",
        "accountNumber": "0000009505020008",
        "bankCode": "6000"
    },
    "creditDebitIndicator": "CRDT",
    "details": {
        "detail1": "Trvalý příkaz 8 1"
    },
    "id": "20221019:0000000220",
    "ownAccountNumber": "2002222222",    
    "postingDate": "2022-10-19",
    "productBankRef": "PS221019SO314822",
    "specificSymbol": "12",
    "statementNumber": "196",
    "statementPeriod": "2022",
    "transactionId": "4831701",
    "transactionType": "DPO",
    "transactionTypeCode": 0,
    "variableSymbol": "12"
},
{
    "amount": {
        "currency": "CZK",
        "value": 2000
    },
    "bankref": "PS221019SO314823",
    "bookingDate": "2022-10-19",
    "counterPartyAccount": {
        "accountName": "PPF BANKA A.S.",
        "accountNumber": "0000009503010009",
        "bankCode": "6000"
    },
    "creditDebitIndicator": "CRDT",
    "details": {
        "detail1": "Na dárky 1"
    },
    "id": "20221019:0000000221",
    "ownAccountNumber": "2002222222",
    "postingDate": "2022-10-19",
    "productBankRef": "PS221019SO314823",
    "specificSymbol": "61",
    "statementNumber": "196",
    "statementPeriod": "2022",
    "transactionId": "4831700",
    "transactionType": "DPO",
    "transactionTypeCode": 1012209,
    "variableSymbol": "61"
},
{
    "amount": {
        "currency": "CZK",
        "value": 100
    },    
    "bankref": "PS221018SO314645",
    "bookingDate": "2022-10-18",
    "counterPartyAccount": {
        "accountName": "PPF BANKA A.S.",
        "accountNumber": "0000009504010019",
        "bankCode": "6000"
    },
    "creditDebitIndicator": "CRDT",
    "details": {
        "detail1": "Příspěvek 3"
    },
    "id": "20221018:0000003607",
    "ownAccountNumber": "2002222222",
    "postingDate": "2022-10-18",
    "productBankRef": "PS221018SO314645",
    "specificSymbol": "12",
    "statementNumber": "195",
    "statementPeriod": "2022",
    "transactionId": "4831425",
    "transactionType": "DPO",
    "transactionTypeCode": 1012209,
    "variableSymbol": "12"
},
{
    "amount": {
        "currency": "CZK",
        "value": 1594
    },
    "bankref": "PS221018SO314645",
    "bookingDate": "2022-10-18",
    "counterPartyAccount": {
        "accountName": "PPF BANKA A.S.",
        "accountNumber": "0000009505020008",
        "bankCode": "6000"
    },
    "creditDebitIndicator": "DBIT",
    "details": {
        "detail1": "Platba elektřiny 3"
    },
    "id": "20221018:0000003608",
    "ownAccountNumber": "2002222222",
    "postingDate": "2022-10-18",
    "productBankRef": "PS221018SO314645",
    "specificSymbol": "12",
    "statementNumber": "195",
    "statementPeriod": "2022",
    "transactionId": "4831381",
    "transactionType": "DPO",
    "transactionTypeCode": 0,
    "variableSymbol": "12"
}
]'_

**Poznámky:**   

Entity counterPartyAccount, statement a transactionType  
se vytvoří v případě, že neexistují.   
V opačném případě se pouze referencují na transaction pomocí business klíčů:  

counterPartyAccount: number  
statement: number  
transactionType: code  

**Read data služby (vracejí seznam transakcí odpovídající danným relacím):**  

GET 134.209.236.1:8099/accounts/2002222222/transactions  
business klíč: ownAccountNumber

GET 134.209.236.1:8099/counterPartyAccounts/0000009505020008/transactions  
business klíč: number  

GET 134.209.236.1:8099/statements/195/transactions  
business klíč: number  

GET 134.209.236.1:8099/trxTypes/0/transactions  
business klíč: code  

**Agregační služby:**  
GET 134.209.236.1:8099/accounts/2002222222/sum  
business klíč: ownAccountNumber  



