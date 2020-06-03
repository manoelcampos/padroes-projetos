linux:
	@# Instala o nodejs e o gerenciador de pacotes (bibliotecas) npm
	sudo apt-get install nodejs npm -y

	@# Usa o npm para instalar o nodemon globalmente (e não na pasta atual) para iniciar facilmente a app servidora
	sudo npm install -g nodemon

	@# Adiciona o caminho das bibliotecas do node ao path do sistema, assim executáveis como o nodemon serão localizados ao serem digitados no terminal
	cat ~/.profile | grep 'PATH:~/node_modules/.bin' > /dev/null || echo 'export PATH=$$PATH:~/node_modules/.bin' >> ~/.profile
	
	@# O comando ". arquivo_script" é o mesmo que "source arquivo_script", mas funciona em diferentes shells.
	. ~/.profile
	
macos:
	brew -v > /dev/null || (echo "Faça download do gerenciador de pacotes Homebrew em http://brew.sh" && exit -1)
	brew install nodejs npm
	sudo npm install -g nodemon
	cat ~/.profile | grep 'PATH:~/node_modules/.bin' > /dev/null || echo 'export PATH=$$PATH:~/node_modules/.bin' >> ~/.profile

	@# O comando ". arquivo_script" é o mesmo que "source arquivo_script", mas funciona em diferentes shells.
	. ~/.profile

clean:
	rm -rf node_modules

remove:
	@# Caso esteja ocorrendo erro na instalação, tente fazer make remove para desinstalar o nodejs e npm
	sudo apt-get remove nodejs npm && sudo apt-get autoremove