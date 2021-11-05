for dir in */; do
    git -C $dir add .
    git -C $dir commit -m "Initial Setup"

    git -C $dir push -u origin main
done
