## Message ##

| **Field**	 | **Start** | 	**Length** | **Type** | **Example**| **Comment** |
|:-----------|:----------|:------------|:---------|:-----------|:------------|
| Magic	 | 0	 | 4	 | chars | 	77,65,84,0 | 	Magic |
| Version	 | 4	 | 2	 | short	 | 0	 | Version  number |
| HeaderLength	 | 6	 | 4	 | int	 | 115	 | Length of the msg header |
| CRC32	 | 10 | 	4 | 	int	| 345	 | Checkum, starting at byte 14 |
| BodyLength | 14	 | 4	 | int	 | 0	 | Length of the msg body |
| Token	 | 18 | 	16 | 	Guid	 | 4d7b45e2-51a6-4b18-908f-d9482dd8bc1c | 	Authentication Token |
| ID	 | 34	 |16 | Guid	 | f7145321-c0ea-4a88-9df1-d6e7067d6fcd	 | Message ID, used to ACK |
| IDGroup	 | 50 | 	16	 | Guid	 | f9f0fcb8-f951-49cf-8c69-f7622d67b90a	 | Group ID, used by split msg |
| IDApplication	 | 66 | 	16 | 	Guid	 | 732fd24a-8117-4a2b-8e55-fed1b57c1f23	 | Application Identifier |
| Created	 | 82 | 	8	 | Date	 | 63420019200	 | time in JavaTime |
| Sender	 | 90 | 	4 | 	int | 	4711	 | id of the sending entity |
| Receiver	 | 90	 | 4	 | int	 |123456	 | id of the receiving entity |
| Opcode	 | 94	 | 1	 | sbyte | 	0	 | EnumOpcode |
| Parts	 | 98 | 4 | 	int | 	1	 | number of msg parts 1 for single message |
| Part	 | 102	 | 4 | 	int | 	0	 | part number |
| Seq	 | 106	 | 4	 | int	| 0 | 	seq number |
| TTL	 | 110	 | 4 | int | 	0	 | time to live |
| Priority	 | 111	 |1	 |byte	 | 1 | 	0 LOW,1 NORMAL,2 HIGH |
| Enryption	 | 112 | 	1 | 	byte	 | 0 | 	0 NONE, 1 TBD |
| Retries	 | 113 | 	1	 | byte |	3	 | Number of retries |
| Encoding | 	114	 | 1	 | byte	 |0 | EnumEncoding |

## ACK ##
| **Field**	 	| **Start**  | **Length** | **Type** | **Example**| **Comment** |
|:------------|:-----------|:-----------|:---------|:-----------|:------------|
| Magic	 	| 0	 	| 4 | chars | 	77,65,84,0 | 	Magic |
| Version	 	| 4	 	| 2 | short	 | 0	 | Version  number |
| HeaderLength	| 6	 	| 4 | int	 | 115	 | Length of the msg header |
| CRC32	 	| 10 		| 4 | int	| 345	 | Checkum, starting at byte 14 |
| BodyLength 	| 14	 	| 4 | int	 | 0	 | Length of the msg body |
| Token	 	| 18 		| 16 | Guid	 | 4d7b45e2-51a6-4b18-908f-d9482dd8bc1c | 	Authentication Token |
| ID	 		| 34	 	| 16 | Guid	 | f7145321-c0ea-4a88-9df1-d6e7067d6fcd	 | Message ID|
| IDACK        | 66		| 16 | Guid	 | 732fd24a-8117-4a2b-8e55-fed1b57c1f23	 | Message ID to confirm |
| Sender	 	| 90 		| 4 | int | 	4711	 | id of the sending entity |
| Receiver	 	| 94		| 4 | int	 |123456	 | id of the receiving entity |
| Opcode	 	| 98	 	| 1 | byte | 	1	 |EnumOpcode |

## NACK ##
| **Field**	 	| **Start** | **Length** | **Type** | **Example**| **Comment** |
|:------------|:----------|:-----------|:---------|:-----------|:------------|
| Magic	 	| 0	 	| 4 | chars | 	77,65,84,0 | 	Magic |
| Version	 	| 4	 	| 2 | short	 | 0	 | Version  number |
| HeaderLength	| 6	 	| 4 | int	 | 115	 | Length of the msg header |
| CRC32	 	| 10 		| 4 | int	| 345	 | Checkum, starting at byte 14 |
| BodyLength 	| 14	 	| 4 | int	 | 0	 | Length of the msg body |
| Token	 	| 18 		| 16 | Guid	 | 4d7b45e2-51a6-4b18-908f-d9482dd8bc1c | 	Authentication Token |
| ID	 		| 34	 	| 16 | Guid	 | f7145321-c0ea-4a88-9df1-d6e7067d6fcd	 | Message ID |
| IDNACK        | 66		| 16 | Guid	 | 732fd24a-8117-4a2b-8e55-fed1b57c1f23	 | Message ID to resend |
| Sender	 	| 90 		| 4 | int | 	4711	 | id of the sending entity |
| Receiver	 	| 94		| 4 | int	 |123456	 | id of the receiving entity |
| Opcode	 	| 98	 EnumOpcode  |

## Location ##

| **Field**	 	| **Start** | **Length** | **Type** | **Example**| **Comment** |
|:------------|:----------|:-----------|:---------|:-----------|:------------|
| Magic	 	| 0	 	| 4 | chars | 	77,65,84,0 | 	Magic |
| Version	 	| 4	 	| 2 | short	 | 0	 | Version  number |
| HeaderLength	| 6	 	| 4 | int	 | 115	 | Length of the msg header |
| CRC32	 	| 10 		| 4 | int	| 345	 | Checkum, starting at byte 14 |
| BodyLength 	| 14	 	| 4 | int	 | 0	 | Length of the msg body |
| Token	 	| 18 		| 16 | Guid	 | 4d7b45e2-51a6-4b18-908f-d9482dd8bc1c | 	Authentication Token |
| ID	 		| 34	 	| 16 | Guid	 | f7145321-c0ea-4a88-9df1-d6e7067d6fcd	 | Message ID,Location will have no ACK |
| IDGroup	 	| 50 		| 16 | Guid	 | f9f0fcb8-f951-49cf-8c69-f7622d67b90a	 | Group ID, used by split msg |
| IDApplication | 66		| 16 | Guid	 | 732fd24a-8117-4a2b-8e55-fed1b57c1f23	 | Application Identifier |
| Created	 	| 82 		| 8 | Date	 | 63420019200	 | time in JavaTime |
| Sender	 	| 90 		| 4 | int | 	4711	 | id of the sending entity |
| Receiver	 	| 94		| 4 | int	 |123456	 | id of the receiving entity |
| Opcode	 	| 98	 	| 1 | sbyte | 	4	 | EnumOcode |
| Latitude		| 99 		| 8 | double | 	47.3686498	 | Latitude|
| Longitude	| 107		| 8 | double | 	8.539182500000038	 | Latitude|
| Satellites	| 115		| 1 | byte	| 3 | 	Number of Satelites |
| Fix	 		| 116		| 4 | byte	| 0 | 	Quality of Fix |