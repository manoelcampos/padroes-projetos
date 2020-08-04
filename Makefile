install:
	@#Instala ferramentas necessárias
	brew install asciidoctor 
	#É preciso adicionar $HOME/.gem/ruby/VERSAO/bin ao path
	gem install asciidoctor-pdf asciidoctor-revealjs --user-install

