#!/bin/sh
siege -c 200 -r 100 -d -f urls.txt -H "Content-Type: application/json"
