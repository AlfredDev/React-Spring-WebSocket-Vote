# Base image with a newer Node version
FROM node:18 as build

# Set working directory
WORKDIR /app

# Install a specific version of npm
RUN npm install -g npm@7

# Install dependencies
COPY package.json /app/package.json
COPY package-lock.json /app/package-lock.json
RUN npm install --legacy-peer-deps

# Add app source code
COPY . /app

# Build the app
RUN npm run build

# Verify the build output
RUN ls -la /app/dist

# Production image, copy all the files and run nginx
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
