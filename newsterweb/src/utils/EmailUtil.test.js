import verifyEmailFormat from "./EmailUtil";

it("correctly verifies email format", () => {
  expect(verifyEmailFormat("john.doe123@gmail.com")).toBe(true);

  expect(
    verifyEmailFormat("apsoidfpasdpfj33444__859@big0lbaby.co.fuckyou.whore")
  ).toBe(true);

  expect(verifyEmailFormat("noAtSymbol.poop.com")).toBe(false);

  expect(verifyEmailFormat("")).toBe(false);
});
