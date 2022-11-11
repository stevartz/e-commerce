import { NextPage } from "next";
import { FormEvent, useState, ChangeEvent } from "react";
import { SignUpRequest } from "../../types/SignUp";

const SignUp: NextPage = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const onChangeUsername = (event: ChangeEvent<HTMLInputElement>) => {
    setUsername(event.target.value);
  };
  const onChangeEmail = (event: ChangeEvent<HTMLInputElement>) => {
    setEmail(event.target.value);
  };

  const onChangePassword = (event: ChangeEvent<HTMLInputElement>) => {
    setPassword(event.target.value);
  };

  const onChangeConfirmPassword = (event: ChangeEvent<HTMLInputElement>) => {
    setConfirmPassword(event.target.value);
  };

  const onSubmitHandler = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    // capture form data and create sign-up request object
    const signUpRequest: SignUpRequest = {
      username,
      email,
      password,
    };

    // TODO: send signup Request to BackEnd
    console.log(signUpRequest);

    // clear all input values
    setUsername("");
    setEmail("");
    setPassword("");
    setConfirmPassword("");
  };

  const labels: string[] = ["Username", "Email", "Password", "Confirm Pasword"];

  return (
    <form
      id="signup-form"
      name="signup-form"
      className="bg-white px-8 pt-6 pb-8 mb-4 w-full sm:w-3/4 mx-auto md:ml-26"
      onSubmit={onSubmitHandler}
    >
      <div className="bg-grey-lighter min-h-screen flex flex-col">
        <div className="container max-w-sm mx-auto flex-1 flex flex-col items-center justify-center px-2">
          <div className="bg-white px-6 py-8 rounded shadow-md text-black w-full">
            <h1 className="mb-8 text-3xl text-center">Sign up</h1>
            {/* Username  */}
            <div className="flex flex-col">
              <label
                htmlFor="username"
                className=" peer block font-bold text-s w-full placeholder-gray-gray4 px-2 pb-1  pt-1.5"
              >
                {labels[0]}
              </label>
              <input
                id="username"
                type="text"
                required
                className="peer first-letter:block border border-grey-light w-full p-3 rounded"
                name="username"
                placeholder="Username"
                onChange={onChangeUsername}
                // value={username}
              />
              <p className="invisible peer-invalid:visible  text-xs text-red-700 mb-1 mt-0">
                Enter your username
              </p>
            </div>
            <div>
              <label
                htmlFor="email"
                className=" block font-bold text-s w-full placeholder-gray-gray4 px-2 pb-1 pt-1.5"
              >
                {labels[1]}
              </label>
              <input
                id="email"
                type="email"
                required
                className="peer selection:block border border-grey-light w-full p-3 rounded"
                name="email"
                placeholder="Email"
                onChange={onChangeEmail}
                value={email}
              />
              <p className="invisible peer-invalid:visible  text-xs text-red-700  mb-1 mt-0">
                Enter your email
              </p>
            </div>
            <div>
              <label
                htmlFor="password"
                className=" block font-bold text-s w-full placeholder-gray-gray4 px-2 pb-1 pt-1.5"
              >
                {labels[2]}
              </label>
              <input
                id="password"
                type="password"
                required
                className="peer block border border-grey-light w-full p-3 rounded"
                name="password"
                placeholder="Password"
                onChange={onChangePassword}
                value={password}
              />
              <p className="invisible peer-invalid:visible  text-xs text-red-700  mb-1 mt-0">
                Enter your password
              </p>
            </div>
            <div>
              <label
                htmlFor="confirm-password"
                className=" block font-bold text-s w-full placeholder-gray-gray4 px-2 pb-1 pt-1.5"
              >
                {labels[3]}
              </label>
              <input
                id="confirm-password"
                type="password"
                className="peer block border border-grey-light w-full p-3 rounded"
                name="confirm_password"
                placeholder="Confirm Password"
                onChange={onChangeConfirmPassword}
                value={confirmPassword}
                required
              />
              <p className="invisible peer-invalid:visible  text-xs text-red-700  mb-4 mt-0">
                Re-enter your password
              </p>
            </div>
            <button
              type="submit"
              className="w-full text-center py-3 rounded bg-green-500 text-white hover:bg-green-dark focus:outline-none my-1"
            >
              Create Account
            </button>
          </div>

          <div className="text-grey-dark mt-6">
            Already have an account?
            <a
              className="no-underline border-b border-blue text-blue"
              href="../login/"
            >
              Log in
            </a>
            .
          </div>
        </div>
      </div>
    </form>
  );
};

export default SignUp;
