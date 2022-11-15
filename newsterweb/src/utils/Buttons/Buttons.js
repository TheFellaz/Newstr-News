import * as React from "react";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import Button from "@mui/material/Button";

const theme = createTheme({
  palette: {
    neutral: {
      main: "#fff",
      contrastText: "#000",
    },
    upload: {
      main: "#5999FF",
      contrastText: "#000",
    },
  },
});

export function LoginButton() {
  return (
    <ThemeProvider theme={theme}>
      <Button color="neutral" variant="outlined" onClick={handleLogin}>
        Login
      </Button>
    </ThemeProvider>
  );
}

export function LogoutButton() {
  return (
    <ThemeProvider theme={theme}>
      <Button color="neutral" variant="outlined" onClick={handleLogout}>
        Logout
      </Button>
    </ThemeProvider>
  );
}

export function AskButton() {
  return (
    <ThemeProvider theme={theme}>
      <Button color="upload" variant="outlined" onClick={handleAsk}>
        AskQuestion
      </Button>
    </ThemeProvider>
  );
}

export function UploadButton() {
  return (
    <ThemeProvider theme={theme}>
      <Button color="upload" variant="outlined" onClick={handleUpload}>
        Upload
      </Button>
    </ThemeProvider>
  );
}
