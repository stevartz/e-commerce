// We will be validating the user inputs using Yup. https://www.npmjs.com/package/yup
// Try to style how you want.
// Add submit

const SignUp = () => {
  return (
    <div className="flex justify-center items-center mt-14">
      <form className="space-y-10">
        <h5 className="text-xl text-center font-medium text-gray-900 dark:text-white">
          Sign Up
        </h5>

        {/* Inputs */}
        <div>
          <label
            htmlFor="username"
            className="block mb-2 text-sm font-medium text-gray-900"
          >
            Username
          </label>
          <input
            id="username"
            type="text"
            placeholder="Username"
            className="bg-gray-50"
          />
        </div>

        <div>
          <label
            htmlFor="email"
            className="block mb-2 text-sm font-medium text-gray-900"
          >
            Email
          </label>
          <input
            id="email"
            type="email"
            placeholder="Email"
            className="bg-gray-50"
          />
        </div>
        <div>
          <label
            htmlFor="email"
            className="block mb-2 text-sm font-medium text-gray-900"
          >
            Password
          </label>
          <input
            id="password"
            type="password"
            placeholder="Password"
            className="bg-gray-50"
          />
        </div>

        <div>
          <label
            htmlFor="confirmPassword"
            className="block mb-2 text-sm font-medium text-gray-900"
          >
            Confirm Password
          </label>
          <input
            id="confirmPassword"
            type="password"
            placeholder="Confirm Password"
            className="bg-gray-50"
          />
        </div>
      </form>
    </div>
  );
};

export default SignUp;
