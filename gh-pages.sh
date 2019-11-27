#!/bin/bash
git co master -B gh-pages || (echo "Não foi possível mudar para branch gh-pages" && exit -1)
find . -name "*.adoc" | xargs asciidoctor -b html 

for FILE in `find . -name "README.html"`; do 
    mv "$FILE" "`dirname $FILE`/index.html"; 
done

for FILE in `find . -name "*.html"`; do 
   git add -f "$FILE"; 
done

git ci -m "Build AsciiDoc Files for GitHub Pages"
git push -f --set-upstream origin gh-pages
git co master
