/**
 * @see https://umijs.org/docs/max/access#access
 * */
export default function access(initialState: InitState | undefined) {
  const { loginUser } = initialState ?? {};
  return {
    canAdmin: loginUser && loginUser.userRole === 'admin',
  };
}
