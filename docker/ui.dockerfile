FROM node:latest

RUN groupmod -g 1001 node && usermod -u 1001 -g 1001 node

RUN groupadd -g 1000 salary_calculator
RUN useradd -u 1000 -ms /bin/bash -g salary_calculator salary_calculator
