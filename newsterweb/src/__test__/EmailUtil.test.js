import verifyEmailFormat from "../utils/EmailUtil";

it("correctly verifies email format", () => {
  expect(verifyEmailFormat("john.doe123@gmail.com")).toBe(true);

  expect(
    verifyEmailFormat("apsoidfpasdpfj33444__859@big0lbaby.co.randomtext.yeah")
  ).toBe(true);

  expect(verifyEmailFormat("noAtSymbol.poop.com")).toBe(false);

  expect(verifyEmailFormat("")).toBe(false);
});
