sseg SEGMENT STACK			; inicio seg. pilha 
	byte 16384 DUP(?)		  
sseg ENDS				; fim seg. pilha

dseg SEGMENT PUBLIC			; inicio seg. dados
	byte 16384 DUP(?)		; temporarios
	sword ?      			; var n int em 16384
	byte  256 DUP (?)      		; var nome string em 16386
	byte ?      			; var naoterminou byte em 16642
	byte 10				; const maxiter byte em 16643
dseg ENDS				; fim seg. dados

cseg SEGMENT PUBLIC 			; inicio do seg. código
	ASSUME CS:cseg, DS:dseg					

_strt:					; inicio do programa
	mov ax, dseg			
	mov ds, ax			

dseg SEGMENT PUBLIC			; inicio seg. dados
	byte "digite seu nome: $"	; const string em 16644
dseg ENDS				; fim seg. dados

	mov dx, 16644			; imprime string na tela
	mov ah, 09h			
	int 21h				

	mov dx, 0			; leitura
	mov al, 0ffh 			
	mov ds:[0], al			
	mov ah, 0ah 			
	int 21h 			
	mov ah, 02h 			; quebra de linha
	mov dl, 0dh 			
	int 21h 			
	mov dl, 0ah 			
	int 21h 			
	mov di, 2			; atribuição da string lida para a variável
	mov si, 16386			
R1: 					
	mov al, ds:[di] 	
	cmp al, 13 	
	je R2 	
	mov ds:[si], al 	
	add di, 1 	
	add si, 1 	
	jmp R1 	
R2: 	
	mov al, 24h 	
	mov ds:[si], al 	

	mov al, 255			; expressão
	mov DS:[0], al

	mov al, DS:[0]			
	mov DS:[16642], al		; atribuição

	mov al, 0			; expressão 
	mov DS:[0], al

	mov al, DS:[0]			
	mov ah, 0
	mov DS:[16384], ax		; atribuição

R3:					; while
	mov al, DS:[16642]		; Comparação 
	cmp al, 0 			
	je R4				


dseg SEGMENT PUBLIC			; inicio seg. dados
	byte "ola' $"			; const ola'  string em 16662
dseg ENDS				; fim seg. dados

	mov dx, 16662			; imprime string na tela
	mov ah, 09h	
	int 21h	

	mov dx, 16386			; imprime string na tela
	mov ah, 09h	 
	int 21h	
	mov ah, 02h			; quebra de linha
	mov dl, 0Dh	
	int 21h	
	mov dl, 0Ah	
	int 21h	

	mov al, 1			; expressão
	mov DS:[0], al
	mov ax, DS:[16384]		
	mov bl, DS:[0]		
	mov cx, ax	
	mov al, bl	
	mov ah, 0
	mov bx, ax
	mov ax, cx	
	add ax, bx	
	mov DS:[1], ax	

	mov ax, DS:[1]			
	mov DS:[16384], ax		; atribuição


	mov ax, DS:[16384]		
	mov bl, DS:[16643]		
	mov cx, ax	
	mov al, bl	
	mov ah, 0
	mov bx, ax
	mov ax, cx	
	cmp ax, bx		 	; comparação
	jl R5
	mov al, 0			
	jmp R6
R5:
	mov al, 255		 
R6:
	mov DS:[0], al	 		; atribuição


	mov al, DS:[0]	
	mov DS:[16642], al		; atribuição

	jmp R3				
R4:					; fim do while

	mov ah, 4Ch			; termina o programa
	int 21h	
cseg ENDS				; fim seg. código

END _strt					
