install:
	@#Instala ferramentas necessárias
	brew install asciidoctor 
	gem install asciidoctor-pdf asciidoctor-revealjs --user-install
	@echo 'É preciso adicionar HOME/.gem/ruby/VERSAO/bin ao path'

