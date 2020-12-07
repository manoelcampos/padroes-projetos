slides:
	@#Compila o README o formato de slides em HTML
	asciidoctor-revealjs slides.adoc -o index.html && echo "Slides HTML gerados com sucesso"

clean:
	@#Apaga os arquivos gerados pelos comandos acima
	rm -f index.html
run:
	ruby -run -e httpd . -p 8081 -b $(shell ipconfig getifaddr en0)