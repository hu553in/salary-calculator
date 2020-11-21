FROM node:latest

RUN groupmod -g 1001 node && usermod -u 1001 -g 1001 node

RUN groupadd -g 1000 salary_calculator
RUN useradd -u 1000 -ms /bin/bash -g salary_calculator salary_calculator

RUN npm i -g npm

ARG APT_KEY_DONT_WARN_ON_DANGEROUS_USAGE=1

RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" \
>> /etc/apt/sources.list.d/google.list'

RUN apt-get update && apt-get install -qy gconf-service libasound2 libatk1.0-0 \
libc6 libcairo2 libcups2 libdbus-1-3 libexpat1 libfontconfig1 libgcc1 \
libgconf-2-4 libgdk-pixbuf2.0-0 libglib2.0-0 libgtk-3-0 libnspr4 libpango-1.0-0 \
libpangocairo-1.0-0 libstdc++6 libx11-6 libx11-xcb1 libxcb1 libxcomposite1 \
libxcursor1 libxdamage1 libxext6 libxfixes3 libxi6 libxrandr2 libxrender1 \
libxss1 libxtst6 ca-certificates fonts-liberation libappindicator1 libnss3 \
lsb-release xdg-utils wget google-chrome-stable
