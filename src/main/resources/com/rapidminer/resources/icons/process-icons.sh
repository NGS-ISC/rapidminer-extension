#!/bin/bash

SRCDIR="../../../../META-INF"
for icon in $(find $SRCDIR -name *-src.png)
do
    bicon=$(basename $icon)
    ticon=$(echo $bicon | sed s/-src//g)
    echo $bicon

    for dir in $(ls -d */)
    do
        scale=$(basename $dir)
        echo "$bicon->$dir$ticon"
        convert $icon -resize ${scale}x${scale} $dir$ticon
    done
done
