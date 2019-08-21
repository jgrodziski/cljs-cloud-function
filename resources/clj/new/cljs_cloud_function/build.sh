#!/bin/sh

JS_BUNDLE_FILENAME="index.js"

npm i
echo "Build \"{{name}}\" Cloud Function in JS bundle file \"$JS_BUNDLE_FILENAME\""

clj -A:build-cloud-function

if [[ $? -eq 0 ]]; then
    echo "\033[32mSuccessfully built artifact \"${JS_BUNDLE_FILENAME}\" for Google Cloud Function \"{{name}}\".\033[0m"
else
    echo "\033[31mFail to built \"name\"'s artifact!\033[0m"
    exit 1
fi

