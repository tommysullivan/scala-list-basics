#!/usr/bin/env bash
set -e
echo "Installing development environment. Assuming Mac OSX"
if ! [ -x "$(command -v brew)" ]; then
    echo "Installing homebrew"
    ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
fi

if ! [ -x "$(command -v scala)" ]; then
    echo "Installing scala language"
    brew install scala
fi

if ! [ -x "$(command -v sbt)" ]; then
    echo "Installing scala build tools"
    brew install sbt
fi
echo "Development environment setup complete"