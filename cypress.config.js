import { defineConfig } from "cypress";

export default defineConfig({
  component: {
    devServer: {
      framework: "react",
      bundler: "vite",
    },
  },

  e2e: {
    defaultCommandTimeout:10000,
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
