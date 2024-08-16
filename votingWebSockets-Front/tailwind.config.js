/** @type {import('tailwindcss').Config} */
export default {
  content: ["./src/**/*.{js,jsx,ts,tsx}",],
  theme: {
    extend: {
      colors: {
        'blue-indigo': '#1E3A8A',
        'blue-light': '#3B5B9A',
        'gray-light': '#F0F4F8',
        'gray-medium': '#B0B8C1',
        'white': '#FFFFFF',
      },
    },
  },
  plugins: [],
}
