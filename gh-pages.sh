#!/bin/bash

git --version || (echo "git is not installed" && exit -1)
asciidoctor -v | head -n 1 || (echo "asciidoctor is not installed" && exit -1)
echo ""

echo "Building GitHub Pages into gh-pages branch."

if [[ $1 == "--help" || $1 == "-h" || $1 == "/h" ]]; then
    echo "  $0     -> Converts AsciiDoc files to HTML into the gh-pages branch and send to GitHub, keeping the change history"
    echo "  $0 -nh -> The same as the previous command, but without keeping the change history (you can also use --no-history)"
    exit 0;
fi

#Pass --no-history or -h to don't keep change history for the gh-pages branch.
#Using that parameter, that branch will keep only the last commit,
#but this slows down the process the build the website for GitHub Pages.
if [[ $1 == "--no-history" || $1 == "-nh" ]]; then
    git branch -D gh-pages 1>/dev/null 2>/dev/null
    echo "The history for the gh-pages branch won't be kept."
    git checkout --orphan gh-pages master 1>/dev/null || (echo "It was not possible to change to gh-pages branch" && exit -1)
else
    echo "Change history in the gh-pages branch will be kept."
    git checkout master -B gh-pages 1>/dev/null || (echo "It was not possible to change to gh-pages branch" && exit -1)
fi
echo ""

echo "Converting AsciiDoc files to HTML"
find . -name "*.adoc" | xargs asciidoctor -b html 

for FILE in `find . -name "README.html"`; do 
    mv "$FILE" "`dirname $FILE`/index.html"; 
done

for FILE in `find . -name "*.html"`; do 
   git add -f "$FILE"; 
done

git commit -m "Build AsciiDoc Files for GitHub Pages" 1>/dev/null 

echo ""
echo "Pushing gh-pages branch to GitHub"
git push -f --quiet --set-upstream origin gh-pages 1>/dev/null 

git checkout master 1>/dev/null 